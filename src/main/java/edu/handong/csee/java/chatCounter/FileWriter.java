package edu.handong.csee.java.chatCounter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * this class writes a csv file with a HashMap
 * @author heeseok
 *
 */
public class FileWriter {
	//HashMap<String, Integer> output = new HashMap<String, Integer>();
	ArrayList<String> kakaoID = new ArrayList<String>();
	String string = null;
	
	/**
	 * this method has two parameters and makes a csv file with them
	 */
	public void writeCSV(String savePath, HashMap<String, Integer> finalOutput) {
		
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(
				          new OutputStreamWriter(
				                       new FileOutputStream(savePath), "UTF8"));
			
			
			bw.write("Kakaotalk_id, Count\n");
			
			
			/*
			 * 할거 1. window용 파서 안돌아감 2. 중복체크되는지확인 3.정
			 */
			//Iterator it = FileWriter.sortByValue(finalOutput).iterator();
			
			for(String keys : finalOutput.keySet()) {
				string = keys + ", " + finalOutput.get(keys) + "\n";
				bw.write(string);
			}
			bw.close();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		} catch (IOException e) {
//				// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 
		
		
		
		 
//	    public CSVWrite() {
//	 
//	    public void writeCsv(List<String[]> data) {
//	        try {
//	            CSVWriter cw = new CSVWriter(new FileWriter(savePath), ',', '"');
//	            Iterator<String[]> it = data.iterator();
//	            try {
//	                while (it.hasNext()) {
//	                    String[] s = (String[]) it.next();
//	                    cw.writeNext(s);
//	                }
//	            } finally {
//	                cw.close();
//	            }
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}

  

	    // Note: this comparator imposes orderings that are inconsistent with equals.    
//	public static HashMap<String, Integer> sortByValue(final HashMap<String, Integer> finalOutput){
//        HashMap<String, Integer> returnHash = new HashMap<>();
//        list.addAll(map.keySet());
//         
//        Collections.sort(list,new Comparator(){
//             
//            public int compare(Object o1,Object o2){
//                Object v1 = map.get(o1);
//                Object v2 = map.get(o2);
//                 
//                return ((Comparable) v1).compareTo(v2);
//            }
//             
//        });
//        Collections.reverse(list); // 주석시 오름차순
//        return list;
//    }
//}
//</string></string,integer></string,integer>

}
