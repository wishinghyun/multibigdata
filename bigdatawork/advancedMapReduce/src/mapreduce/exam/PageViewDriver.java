package mapreduce.exam;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class PageViewDriver extends Configured implements Tool{

	@Override
	public int run(String[] optionlist) throws Exception {
		GenericOptionsParser parser = 
				new GenericOptionsParser(getConf(), optionlist);
		String[] otherArgs = parser.getRemainingArgs();
		
		Job job = new Job(getConf(), "pageView");
		
		job.setMapperClass(PageViewMapper_ver1.class);
		job.setReducerClass(PageViewReducer_ver1.class);
		job.setJarByClass(PageViewDriver.class);
		
		//Shuffle할때 사용할 클래스를 사용자정의 클래스가 실행되도록 등록
		job.setPartitionerClass(MyKeyPartitioner.class);
		job.setGroupingComparatorClass(GroupKeyComparator.class);
		job.setSortComparatorClass(MyKeyComparator.class);
		job.setMapOutputKeyClass(MyKey.class);
		job.setMapOutputValueClass(IntWritable.class); //ver1
		//job.setMapOutputValueClass(Text.class); //ver2
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		
		job.waitForCompletion(true);
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		ToolRunner.run(new Configuration(),
					   new PageViewDriver(),
					   args);
	}
	
}
