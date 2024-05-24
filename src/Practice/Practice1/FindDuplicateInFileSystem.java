import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class FindDuplicateInFileSystem {
	public static void main(String args[]) {
		String[] dirInfo = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		System.out.println(findDuplicate(dirInfo));
	}

	public static List<List<String>> findDuplicate(String[] dirInfo) {
		HashMap<String, List<String>> fileMap = new HashMap<>();

		for(String dir: dirInfo) {
			String[] temDir = dir.split(" ");
			String dirLoc = temDir[0];
			List<String> tempList;
			for(int i=1; i<temDir.length; i++) {
				String[] tempFile = temDir[i].split("\\(");
				String fileName=tempFile[0];
				String content=tempFile[1].substring(0,tempFile[1].length());
				if(!fileMap.containsKey(content)) {
					tempList=new ArrayList<String>();
					tempList.add(dirLoc+"/"+fileName);
					fileMap.put(content, tempList);
				} else {
					tempList=fileMap.get(content);
					tempList.add(dirLoc+"/"+fileName);
					fileMap.put(content, tempList);
				}
			}
		}
		List<List<String>> result = new ArrayList<>();
		for(String content : fileMap.keySet()) {
			List<String> tempList = fileMap.get(content);
			if(tempList.size()>1) result.add(tempList);
		}

		return result;
	}	
}