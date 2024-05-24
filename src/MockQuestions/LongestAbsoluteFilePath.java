// incomplete

class LongestAbsoluteFilePath {
	public static void main(String args[]) {
		// String path = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        // String path = "file0.ext\ndir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext\n\tfile2.ext\nfile3.ext";
        String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

		System.out.println(lengthLongestPath(path));
	}

	public static int lengthLongestPath(String input) {
        maxLen = 0;
        index = 0;
        String[] locs = input.split("\n");

        for(String loc: locs) {
            System.out.println(loc);
        }

        while(index<locs.length) {
            dfs(locs, 0);
        }

        return maxLen;
    }

    static int maxLen;
    static int index;

    public static void dfs(String[] paths, int lengthSoFar) {
        if(index==paths.length) return;

        String path = paths[index++];
        System.out.println(path+": "+lengthSoFar);

        int tabs = path.lastIndexOf('\t') + 1;

        if(index<paths.length) {
                String next = paths[index];
                while(tabs<next.lastIndexOf('\t') + 1) {
                    dfs((paths, lengthSoFar +   ))
                }

        if(path.contains(".")) {
            maxLen = Math.max(lengthSoFar+path.strip().length(), maxLen);
        } else {
            if(index<paths.length) {
                String next = paths[index];
                if(tabs<(next.lastIndexOf('\t') + 1)) {
                    lengthSoFar+= (path.strip().length() + 1);
                }
            }
            dfs(paths, lengthSoFar);
        }
    }
}
