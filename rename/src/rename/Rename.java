package rename;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

public class Rename {

	static List<String> files = new ArrayList();;
	public static final int BUFSIZE = 1024 * 8;

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		String path = "E:\\Users\\Ruimeng Jin\\Desktop\\LTE_UL_LL_v1_6_SAI Version_v1";
		String outFile = "E:\\Users\\Ruimeng Jin\\Desktop\\merge.txt";

		getNew(path);

		if (files != null) {
			mergeFiles(outFile, files);
		}

	}

	private static void getNew(String path) {
		File file = new File(path);
		// 得到文件夹下的所有文件和文件夹
		String[] list = file.list();

		if (list != null && list.length > 0) {
			for (String oldName : list) {
				File oldFile = new File(path, oldName);
				// 判断出文件和文件夹
				if (!oldFile.isDirectory()) {
					// 文件则判断是不是要修改的
					if (oldName.endsWith(".m")) {
						System.out.println(oldName);
						String newoldName = oldName.substring(0, oldName.lastIndexOf(".")) + ".txt";
						System.out.println(newoldName);
						File newFile = new File(path, newoldName);
						boolean flag = oldFile.renameTo(newFile);
						System.out.println(flag);
						if (flag) {
							files.add(path+ "\\" + newoldName);
						}
					} else if (oldName.contains(".txt")) {
						files.add(path+"\\"+oldName);
					}
				} else {
					// 文件夹则迭代
					String newpath = path + "/" + oldName;
					getNew(newpath);
				}
			}
		}
	}

	public static void mergeFiles(String outFile, List<String> files) {
		FileChannel outChannel = null;
		System.out.println("Merge " + " into " + outFile);
		try {
			outChannel = new FileOutputStream(outFile).getChannel();
			for (String f : files) {
				Charset charset = Charset.forName("utf-8");
				CharsetDecoder chdecoder = charset.newDecoder();
				CharsetEncoder chencoder = charset.newEncoder();
				FileChannel fc = new FileInputStream(f).getChannel();
				ByteBuffer bb = ByteBuffer.allocate(BUFSIZE);
				CharBuffer charBuffer = chdecoder.decode(bb);
				ByteBuffer nbuBuffer = chencoder.encode(charBuffer);
				while (fc.read(nbuBuffer) != -1) {

					bb.flip();
					nbuBuffer.flip();
					outChannel.write(nbuBuffer);
					bb.clear();
					nbuBuffer.clear();
				}
				fc.close();
			}
			System.out.println("Merged!! ");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (outChannel != null) {
					outChannel.close();
				}
			} catch (IOException ignore) {
			}
		}
	}

}
