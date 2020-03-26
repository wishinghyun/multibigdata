package mapreduce.exam;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyKeyPartitioner2 extends Partitioner<MyKey, Text>{//<>는 
															//mapper의 아웃풋키 벨류와 동일

	@Override
	public int getPartition(MyKey key, Text value, int numPartitions) {
		
		return key.getProductId().hashCode() % numPartitions;
	}
	
}
