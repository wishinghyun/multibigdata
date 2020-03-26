package mapreduce.air.sort;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirSortMapper 
		extends Mapper<LongWritable, Text, CustomKey, IntWritable>{
	static final IntWritable one = new IntWritable(1);
	CustomKey outputKey = new CustomKey();
	@Override
	protected void map(LongWritable key,
					   Text value,
					   Mapper<LongWritable, Text, CustomKey, IntWritable>.Context context)
			throws IOException, InterruptedException {
		if(key.get() > 0) {
			String[] line = value.toString().split(",");
			if(!line[15].equals("NA") && line.length>0) {
				double time = Double.parseDouble(line[15]);
				if(time>0) {
					outputKey.setYear(line[0]);
					outputKey.setMonth(new Integer(line[1]));
					outputKey.setMapkey(key.get());//key타입이 longwritable이므로 .get()으로 넘겨줌
					context.write(outputKey, one);
				}
			}
		}
	}
	
	
}
