class WriteLetter {
	static public void main( String args[] ) {
    System.out.println("asdsa");
     System.out.println(writeLetter("hello", "kjsdhfgkseasdaasdalasdadsodsagh"));
  }
  
  static public boolean writeLetter(String l, String n) {
    int[] dict = new int[128];
    
    for(char c: n.toCharArray()) {
      dict[c]++;
    }
    
    for(char c: l.toCharArray()) {
      if(dict[c]<1) {
        return false;
      }
      dict[c]--;
    }
    return true;
  }
}