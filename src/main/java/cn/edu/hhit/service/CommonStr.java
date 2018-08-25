package cn.edu.hhit.service;

/**
 * @author zhangbo
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/8/2410:41
 */
public class CommonStr {
    public static void main(String[] args) {
        String str1 = "abcsdeffsad";
        String str2 = "sdadwasdssabcsdwaabc";
        System.out.println(CommonStr.getMaxSubstring(str1,str2));

    }
    public static String getMaxSubstring(String str1,String str2){
        if (str1==null||str2==null) return "";
        if (str1.equals("")||str2.equals("")) return "";
        String max = "";
        String min = "";
        if (str1.length()>str2.length()){
            max = str1;
            min = str2;
        }else{
            min = str1;
            max = str2;
        }
        String target="";
        //遍历短字符串。并且依此减少字符串的字符数量，判断长字符串是否包含改该串
        //最外层：min子串的长度，从最大长度开始
        for (int i = min.length(); i >= 1; i--) {
            //遍历长度为i的min子串，从0开始
            for (int j = 0; j <= min.length() - i; j++) {
                target = min.substring(j, j + i);
                //遍历长度为i的max子串，判断是否与target子串相同，从0开始
                for (int k = 0; k <= max.length() - i; k++) {
                    if (max.substring(k,k + i).equals(target)) {
                        return target;
                    }
                }
            }
        }
        return "";
    }
}
