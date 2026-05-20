class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0){
            return "";
        }
        String str = strs.get(0);
        if(str.equals("")){
            str+="Ã";
        }
        for(int i=1; i<strs.size(); i++){
            String temp = strs.get(i);
            if(temp.equals("")){
                temp += "Ã";
            }
            str = str + "Â" + temp;
        }
        return str;
    }

    public List<String> decode(String str) {
        String arr[] = str.split("Â");
        List<String> listOfString = new ArrayList<>();
        for(String ele: arr){
            if(ele.equals("Ã")){
                listOfString.add("");
            }
            else{
                listOfString.add(ele);
            }
        }
        System.out.println(listOfString);
        return listOfString;
    }
}


// "",""
