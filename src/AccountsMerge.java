/*
给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。

示例 1：

输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
解释：
第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。

示例 2：

输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]

题号：721
* */

/*
* 知识点：容器，类
* */

import java.util.*;

public class AccountsMerge {
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        Map<String, List<Integer>> sameName = new HashMap<>();
//
//        for (int i = 0; i < accounts.size(); i++) {
//            List<Integer> value = sameName.get(accounts.get(i).get(0));
//            if (value == null) {
//                List<Integer> indexes = new ArrayList<>();
//                indexes.add(i);
//                sameName.put(accounts.get(i).get(0), indexes);
//            } else {
//                value.add(i);
//            }
//        }
//
//        List<Integer> remove = new ArrayList<>();
//        for (String key : sameName.keySet()) {
//            List<Integer> value = sameName.get(key);
//            if (value.size() > 1) {
//                for (int i = 0; i < value.size(); i++) {
//                    boolean merged = true;
//                    int index1 = value.get(i);
//                    if (index1 == -1) {
//                        continue;
//                    }
//
//                    while (merged) {
//                        merged = false;
//                        for (int j = i + 1; j < value.size(); j++) {
//                            int index2 = value.get(j);
//                            if (index2 == -1) {
//                                continue;
//                            }
//
//                            for (int k = 1; k < accounts.get(index2).size(); k++) {
//                                if (accounts.get(index1).contains(accounts.get(index2).get(k))) {
//                                    List<String> mergeList = Stream.concat(accounts.get(index1).stream(), accounts.get(index2).stream()).collect(Collectors.toList());
//                                    accounts.set(index1, mergeList);
//                                    value.set(j, -1);
//                                    remove.add(index2);
//                                    merged = true;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        remove.sort(Collections.reverseOrder());
//        for (Integer integer : remove) {
//            accounts.remove(integer.intValue());
//        }
//
//        for (int i = 0; i < accounts.size(); i++) {
//            List<String> account = accounts.get(i);
//            List<String> sublist = account.subList(1, account.size());
//            Collections.sort(sublist);
//            accounts.set(i, account.stream().distinct().collect(Collectors.toList()));
//        }
//
//        return accounts;
//    }

    // TODO need to review
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
