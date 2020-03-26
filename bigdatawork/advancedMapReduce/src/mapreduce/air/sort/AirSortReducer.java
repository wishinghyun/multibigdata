package mapreduce.air.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AirSortReducer extends Reducer<CustomKey, IntWritable, CustomKey, IntWritable>{
	IntWritable resultVal = new IntWritable();
	CustomKey resultKey = new CustomKey();
	Text appenddata = new Text();
	String data = "";
	@Override
	protected void reduce(CustomKey key,
					Iterable<IntWritable> values,
					Reducer<CustomKey, IntWritable, CustomKey, IntWritable>.Context context)
											throws IOException, InterruptedException {
		int sum = 0;
		//month데이터를 추출
		data = data + "reduce호출";
		appenddata.set(data);
		Integer beforeMonth = key.getMonth();
		int count = 0;
		for(IntWritable value:values) {
			if(count<10) {
				System.out.println("reduce=>"+key);
				count++;
			}
			if(beforeMonth!=key.getMonth()) {
				resultKey.setYear(key.getYear()
								  +","+appenddata+"(테스트문자열),"
								  +key.hashCode()+"(해쉬코드),"
								  +key.getMapkey()+"(map에서 전달한 키)");
				resultKey.setMonth(beforeMonth);
				resultVal.set(sum);
				context.write(resultKey, resultVal);
				sum = 0;
			}
			sum = sum + value.get();
			beforeMonth = key.getMonth();
		}
		//values에 전달된 값들을 반복작업하며 마지막에 같은 키를 갖고 있는 값을 한꺼번에 출력
		// - 키(year,month)가 둘 다 같은 경우
		if(key.getMonth()==beforeMonth) {
			resultKey.setYear(key.getYear());
			resultKey.setMonth(key.getMonth());;
			resultVal.set(sum);
			context.write(resultKey, resultVal);
		}
	}

}
