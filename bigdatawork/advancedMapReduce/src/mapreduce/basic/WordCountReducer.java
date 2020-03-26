package mapreduce.basic;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer 
			extends Reducer<Text, IntWritable, Text, IntWritable>{
	IntWritable resultVal = new IntWritable();
	Text appenddata = new Text();
	String data = "";
	Text resultKey = new Text();
	@Override
	protected void reduce(Text key,
					Iterable<IntWritable> values,
					Reducer<Text, IntWritable, Text, IntWritable>.Context context)
											throws IOException, InterruptedException {
		int sum = 0;
		data = data + "reduce호출";
		appenddata.set(data);
		for(IntWritable value:values) {
			sum = sum + value.get();
		}
		resultVal.set(sum);
		resultKey.set(key+":"+appenddata);
		context.write(resultKey, resultVal);
	}
	
	
}
