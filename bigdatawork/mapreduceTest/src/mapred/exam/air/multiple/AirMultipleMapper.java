package mapred.exam.air.multiple;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
//하둡을 실행할때 사용자가 입력하는 옵션을 Mapper내부에서 사용할 수 있도록
//옵션이 어떤 값으로 입력되었냐에 따라 다른 작업을 할 수 있도록 처리
public class AirMultipleMapper 
		extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable one = new IntWritable(1);
	Text outputKey = new Text();

	@Override
	protected void map(LongWritable key,
					   Text value,
					   Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		if(key.get() > 0) {
			String[] data = value.toString().split(",");
			if(data!=null & data.length>0) {
				if(!data[15].equals("NA")) {
					if(Integer.parseInt(data[15])>0) {
						outputKey.set("depdelay,"+data[1]);
						context.write(outputKey, one);
					}
				}else if(data[15].equals("NA")) {
					outputKey.set("depNA,"+data[1]);
					context.write(outputKey, one);
				}
				if(!data[14].equals("NA")) {
					if(Integer.parseInt(data[14])>0) {
						outputKey.set("arrdelay,"+data[1]);
						context.write(outputKey, one);
					}
				}
				else if(data[14].equals("NA")) {
					outputKey.set("arrNA,"+data[1]);
					context.write(outputKey, one);
				}
			}
	}
	
	}
	}
