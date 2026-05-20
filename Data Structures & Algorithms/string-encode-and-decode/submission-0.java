class Solution {

    public String encode(List<String> strs) {
        String str = strs.get(0);
        for(int i=1; i<strs.size(); i++){
            str = str + "_" + strs.get(1);
        }
        return str;
    }

    public List<String> decode(String str) {
        String arr[] = str.split("_");
        List<String> listOfString = Arrays.asList(arr);
        return listOfString;
    }
}
