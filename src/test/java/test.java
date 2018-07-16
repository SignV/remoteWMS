import com.signv.utils.ByteUtils;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
//        String strXML = "3000㎡";
//        String m2 = strXML.substring(strXML.length()-1);
//        System.out.println(m2);
//        if(!m2.equals("㎡")){
//            strXML += "㎡";
//        }
//        System.out.println(strXML);
//        int i = 1;
//        int x = i/1;
//        System.out.println(x);

        byte[] data = new byte[12];
//        data = new byte[]{0x30, 0x75, 0x1F, (byte) 0xEB, 0x70, 0x5C, 0x59, 0x04,(byte) 0xE3,(byte) 0xD5, 0x0D, 0x70};
        data[0] = (byte) 0xbb;
        System.out.println(ByteUtils.byte2hex(data));
        int dataChange1 = data[0];
        int dataChange2 = Integer.valueOf(data[0]);
        System.out.println(dataChange1 +" "+ dataChange2 + " " + data.length);
//        if(dataChange == 12){
//            System.out.println("!!!");
//        }


//        System.out.println(data[1]);
//        System.out.println(data[2]);
    }
}
