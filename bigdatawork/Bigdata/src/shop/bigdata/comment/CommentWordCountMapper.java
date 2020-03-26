package shop.bigdata.comment;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CommentWordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	static final IntWritable outputVal = new IntWritable(1);
	Text outputKey = new Text();
	@Override
	protected void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, Text, IntWritable>.Context context)
										throws IOException, InterruptedException {
		String[] line = value.toString().split(",");
		StringTokenizer st = new StringTokenizer(line[2]);
		String patternStr = "은$||는$||이$||가$||의$||요$";
		String replace = "";
		
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			replace = equalPattern(str, patternStr);
			outputKey.set(replace);		
			context.write(outputKey, outputVal);
		}
	}
	public static String equalPattern(String str, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher m = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while(m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
}