/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.phsa.esti.common.utils;

/**
 *
 * @author kai.du
 */
public class StringUtility {
    public static final char LF = '\n';
    public static final char CR = '\r';
    public static boolean equalsIgnoreNewlineTwirks(String str, String other){
        if (str == null || other == null){
            return false;
        }
        if (str.equals(other)){
            return true;
        }

        char[] s1 = str.toCharArray();
        char[] s2 = other.toCharArray();
        int index1 = 0, index2 = 0;
        while (true){
            boolean oob1 = index1 >= s1.length, oob2 = index2 >= s2.length;
            if (oob1 | oob2){
                if(!oob1){
                    while(index1 < s1.length){
                        if(s1[index1]!=LF && s1[index1]!=CR)break;
                        index1++;
                    }
                 oob1 = index1 >= s1.length;
                }
                else if(!oob2){
                    while(index2 < s2.length){
                        if(s2[index2]!=LF && s2[index2]!=CR)break;
                        index2++;
                    }
                   oob2 = index2 >= s2.length;
                }
                return oob1 & oob2;
            }

            char ch1 = s1[index1], ch2 = s2[index2];
            if (ch1 != ch2){
                if (ch1 != LF && ch1 != CR && ch2 != LF && ch2 != CR) return false;

                if (index1 + 1 < s1.length && (ch1 == LF || ch1 == CR)){
                    index1++;
                }
                if (index2 + 1 < s2.length && (ch2 == LF || ch2 == CR)){
                    index2++;
                }
                index1--; index2--;
            }
            index1++; index2++;
        }
    }

    private static boolean isCRAndLF(char ch1, char ch2){
        return (ch1 == CR && ch2 == LF) || (ch1 == LF && ch2 == CR);
    }
}
