package hdfs.exam;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class HDFSExam02 {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		FileSystem hdfs = null;
		FSDataInputStream hdfsin = null;
		try {
			hdfs = FileSystem.get(conf);
			
			//HDFS로부터 읽을 파일의 경로를 명령행매개변수로 받아서 적용하겠다는 의미
			Path path = new Path(args[0]);
			
			//HDFS에 저장된 파일을 읽어야하므로 스트림 생성하기
			hdfsin = hdfs.open(path);
			
			//입력스트림을 통해 데이터를 읽는다
			String data = hdfsin.readUTF();
			System.out.println("hdfs에서 읽을 데이터:"+data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
