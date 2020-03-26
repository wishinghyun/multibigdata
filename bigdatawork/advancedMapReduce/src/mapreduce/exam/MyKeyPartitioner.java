package mapreduce.exam;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyKeyPartitioner extends Partitioner<MyKey, IntWritable>{//<>는 
															//mapper의 아웃풋키 벨류와 동일

	@Override
	public int getPartition(MyKey key, IntWritable value, int numPartitions) {
		
		return key.getProductId().hashCode() % numPartitions;
	}
	
}
