package mapreduce.exam;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PageViewMapper_ver1 extends Mapper<LongWritable, Text, MyKey, IntWritable>{
	static final IntWritable one = new IntWritable(1);
	MyKey outputKey = new MyKey();

	@Override
	protected void map(LongWritable key, 
					   Text value, 
					   Mapper<LongWritable, Text, MyKey, IntWritable>.Context context)
							   					throws IOException, InterruptedException {
		String line = value.toString();
		String[] data = line.split("\\t");//\\t는 tab
		//data[2] = product, data[9] = userId
		outputKey.setProductId(data[2]);
		outputKey.setUserId(data[9]);
		context.write(outputKey, one);
		
	}
}
