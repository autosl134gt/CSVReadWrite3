package csvreadwritest3;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class CsvReadWrite {

    static CSVReader csvr;
    CSVWriter csvw;
    String[] nextLine;
    private static final String testCsvFile = "D:\\workspace\\TestData\\csv01.csv";
    private static final String testCsvFile2 = "D:\\workspace\\TestData\\csv02.csv";
    
    @BeforeClass
    public static void setUp() throws Exception {
        StringBuilder sb = new StringBuilder(CSVParser.INITIAL_READ_SIZE);
        sb.append("Tom Johns,aaa@gmail.com,(123)1231234").append("\n");  
        sb.append("Britney Spears,zzz@gmap.com,(222)2222222\n");
        sb.append("Samantha Cole,www@gmap.com,(333)2222222\n");
        sb.append("Helen Kane,ccc@gmap.com,(444)2222222\n");
        sb.append("Miley Cyrus,fff@gmap.com,(555)2222222\n");
        sb.append("Belinda Carlisle,bbb@gmap.com,(666)2222222\n");
        csvr = new CSVReader(new StringReader(sb.toString()));
    }

    @Test
    public void testCsvFileWriter() throws IOException {
 	
		csvw = new CSVWriter(new FileWriter(testCsvFile));

		while ((nextLine = csvr.readNext()) != null)
        	csvw.writeNext(nextLine);
 
		csvw.close();
       
    }
    
    @Test
    public void testReadNext() throws IOException {

    	CSVReader csvr = new CSVReader(new FileReader(testCsvFile));
 
    	while ((nextLine = csvr.readNext()) != null)
    		System.out.println("Name: [" + nextLine[0] + "]\nAddress: [" + nextLine[1] + "]\nEmail: [" + nextLine[2] + "]");

    	csvr.close();
       
    }
    
    @Test
    public void testReadWriteAll() throws IOException {
    	
        CSVReader csvr2 = new CSVReader(new FileReader(testCsvFile));

        List<String[]> allElements = csvr2.readAll();
        
        CSVWriter csvw2 = new CSVWriter(new FileWriter(testCsvFile2));
        
        csvw2.writeAll(allElements);
        
        csvr2.close();
        csvw2.close();
        
    }
        

}

