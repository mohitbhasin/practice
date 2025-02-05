class MinMoveToPalindrome {
	public static void main(String args[]) {
		String[] strs = {"eggeekgbbeg", "ccxx", "arcacer", "w", "ooooooo", "olstzgogeivvvgctrsbusvihcvbzzvsscycituqylxjoknhrcvuuzbtzlitovccykivkuavxzgvlmtiqtnmshonqclcknptabpewxxtqnvreoiyucsujxooxhoxwqirtqfzbgjgpsvlsmqfbmcsqlxirogcbwuiepmzifcljytcpougvfrihfjztikkjjtoyszhmfdqculcrmlwdameewzfznakyfgktonpqqouhnvvddtsoaxtbwhhyekokxpizxlhpdfghctuigaqcvpqsopgjrxoiroyfitofwojveowkqvosyqjuesovhqhrvryvdjbtykrvdrvrlyrayccfzzvcuagzziwmtbnrlvyytomwlzqqyworqmwuhnorihzgnrwbqbyqakrmfkdhutjlvjikxybztupvwqrrnxnfybbshxrbuwyxxgbrkbkvwutrcdtcryffdclccfdgljubxxefnxfvqfvwmtqyehslovoskmxdgiuncvlravylmdenqgzbirfvvakflzstzysfdmziurzmunxvijdlkjyrxlyndzleujdzhlcvuffbwsutlkbpqihdmqlbphvnhqgctogiqzsiwttbfycjbbwhhpfduuldcjwinrzuvspmumgzujyyhtqcekfrvcihnhhshnvipzjtjocmazghntrnruwkmko"};
		for(String s: strs) {
			System.out.println(minMovesToMakePalindrome(s));
		}
	}

	public static int minMovesToMakePalindrome(String s) {
    	char[] schar = s.toCharArray();
        
        int moves = 0;
        int i = 0;
        int j = schar.length - 1;
        while(i<j) {
          int k=j;
            while(k>i) {
              if(schar[i]==schar[k]) {
                moves+=swapMoves(schar, k, j);
                j--;
                break;
              }
              k--;
            }
            if(k==i) moves+=s.length()/2-i;
          // }
          i++;
        }
        return moves;
    }
    
    public static int swapMoves(char[] schar, int x, int y) {
      int count = 0;
      while(x<y) {
        char temp = schar[x];
        schar[x] = schar[x+1];
        schar[x+1] = temp;
        x++;
        count++;
      }
      return count;
    }
}