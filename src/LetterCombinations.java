import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

 * 示例 2：
 * 输入：digits = ""
 * 输出：[]

 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]

 * 题号：17

 * 知识点：回溯
* */

public class LetterCombinations {
    private HashMap<Character, String[]> letters = new HashMap<>();
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }

        letters.put('2', new String[]{"a", "b", "c"});
        letters.put('3', new String[]{"d", "e", "f"});
        letters.put('4', new String[]{"g", "h", "i"});
        letters.put('5', new String[]{"j", "k", "l"});
        letters.put('6', new String[]{"m", "n", "o"});
        letters.put('7', new String[]{"p", "q", "r", "s"});
        letters.put('8', new String[]{"t", "u", "v"});
        letters.put('9', new String[]{"w", "x", "y", "z"});

        combine(digits, new StringBuilder(), 0);
        return result;
    }

    private void combine(String digits, StringBuilder str, int digitsIdx) {
        if (digitsIdx == digits.length()) {
            // 树到达底层，得到一种组合
            result.add(str.toString());
        } else {
            char digit = digits.charAt(digitsIdx);
            String[] letter = letters.get(digit);
            for (String l : letter) {
                str.append(l);
//                System.out.println("layer: " + digitsIdx);
//                System.out.println(str);
                combine(digits, str, digitsIdx + 1);
                // 回溯逻辑，达到树的最低层后，递归地删除每层对应的字符
                str.deleteCharAt(digitsIdx);
            }
        }
    }
}
