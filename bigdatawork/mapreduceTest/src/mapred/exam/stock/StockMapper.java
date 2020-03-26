package mapred.exam.stock;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockMapper 
			extends Mapper<LongWritable, Text, Text, IntWritable>{
	
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text(); //output key

	@Override
	protected void map(LongWritable key,
					   Text value,
					   Mapper<LongWritable, Text, Text, IntWritable>.Context context)
							   				throws IOException, InterruptedException {
		
		if(key.get() > 0) {
			String[] line = value.toString().split(",");
			if(line!=null & line.length > 0) {
				//년도, 상승마감
				outputKey.set(line[2].substring(0, 4));
				double result = Double.parseDouble(line[6]) - Double.parseDouble(line[3]);
				if(result>0) { //상승마감
					context.write(outputKey, outputVal);
				}
			}
		}
		
	}
	
	
}
