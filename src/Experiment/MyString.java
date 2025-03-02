package Experiment;


class string{
    private char arr [];
    string(String str){
        arr = new char[str.length()];
        for(int i=0;i<str.length();i++){
            arr[i]= str.charAt(i);
        }
    }

    string(char arr[]){
        this.arr=arr;
    }

    @Override
    public String toString() {
        return new String(arr);
    }

    public  int length(){
        return arr.length;
    }
    public boolean isEqual(string s2){
        if(this.arr.length!= s2.arr.length)
            return false;

        for(int i=0;i<this.arr.length;i++){
            if(arr[i]!=s2.arr[i])
                return false;
        }
        return true;
    }

    public char charAt(int index){
        return arr[index];
    }

    public char[] toCharArray(){
        return arr;
    }

    public string substring(int start){
        return  substring(start,this.arr.length);
    }
    public string substring(int start,int end){
        if(start<0 || end> this.arr.length) return null;

        int len = end-start+1;
        char ans[] =new char[len];

        for(int i=start;i<end;i++){
            ans[i-start]= this.arr[i];
        }
        return  new string(ans);
    }
}
public class MyString {
    public static void main(String[] args) {

        string str = new string("Hello World!");
        string str2 = new string("Hello World!");
        string str3 = str;
        System.out.println(str);
        System.out.println(str.substring(3));
        System.out.println(str.substring(3,5));
        System.out.println(str.length());

        System.out.println(str == str2);
        System.out.println(str==str3);

        System.out.println(str.isEqual(str2));
    }
}

