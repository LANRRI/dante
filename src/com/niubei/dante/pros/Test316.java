package com.niubei.dante.pros;

public class Test316 {
    public String removeDuplicateLetters(String s) {
//代表SB中已经存在的元素
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
//      计算所有字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
//代表单调栈，维护去除关键字符后的字符串
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
//            在考虑字符 s[i]s[i] 时，如果它已经存在于栈中，则不能加入字符 s[i]s[i]。为此，需要记录每个字符是否出现在栈中。
            if (!vis[ch - 'a']) {
//              直到栈顶元素小于当前元素，跳出循环，将ch 插入sb中
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
