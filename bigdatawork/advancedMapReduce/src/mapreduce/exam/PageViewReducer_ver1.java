package mapreduce.exam;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageViewReducer_ver1 extends Reducer<MyKey, IntWritable, Text, Text>{
	Text resultVal = new Text();
	Text resultKey = new Text();
	
	
	@Override
	protected void reduce(MyKey key, Iterable<IntWritable> values,
			Reducer<MyKey, IntWritable, Text, Text>.Context context) 
									throws IOException, InterruptedException {
		
		int sum = 0;//하나의 상품이 클릭된 총 횟수
		int user_count = 1;//클릭한 사용자 수
		String beforeUser = key.getUserId();
		
		for (IntWritable value : values) {
			System.out.println(key.toString());
			if(beforeUser.equals(key.getUserId())) {
				user_count = user_count+1;
			}
			sum = sum + value.get();
			beforeUser = key.getUserId();
		}
		resultKey.set(key.getProductId());
		resultVal.set(user_count+"\t"+sum);//스트링처리해주려고 ""해줌
		context.write(resultKey, resultVal);
	}
}
