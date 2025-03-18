package StringAndIts_Functions;

public class Compare_StringBuffer_StringBuilder {
        public static void main(String[] args) {
            long startTime, endTime;

            StringBuilder sb = new StringBuilder();
            startTime = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                sb.append("hello");
            }
            endTime = System.nanoTime();
            System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");

            StringBuffer sbf = new StringBuffer();
            startTime = System.nanoTime();
            for (int i = 0; i < 1000000; i++) {
                sbf.append("hello");
            }
            endTime = System.nanoTime();
            System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");
        }
}
