import jdk.internal.module.ModuleLoaderMap;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import javax.print.attribute.standard.Destination;
import java.io.IOException;

public class FlightJoinMapper extends ModuleLoaderMap.Mapper <LongWritable, Text, AirportWritableComparable, Text> {
    private static final String SEPERATOR = ",";
    private static final String CSV_COLOUM_NAME = "\"DEST_AIRPORT_ID\"";
    private static final int Destination_AIRPORT_ID_INDEX = 14;
    private static final int DELAY_INDEX = 17;






    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException, NumberFormatException {
        String[] values = value
                .toString()
                .split(SEPERATOR);
        String airportIDString = value[Destination_AIRPORT_ID_INDEX];

        if (!airportIDString.equals((CSV_COLOUM_NAME)) {
            int airportID = Integer.parseInt(airportIDString);
            String delay = value[DELAY_INDEX];
            if (delay.length() != 0) {
                context.write();
            }

        }
    }
}
