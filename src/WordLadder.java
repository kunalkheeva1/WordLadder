import java.util.*;

class Pair{
    int level;
    String currWord;
    Pair(String currWord, int level){
        this.currWord =currWord;
        this.level = level;
    }
}



public class WordLadder {

    public static int wordLadder(String beginWord, String endWord, List<String> wordList){
        HashSet<String> hs = new HashSet<>(wordList);
        hs.remove(beginWord);

        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(beginWord, 1);
        q.add(pair);

        while(!q.isEmpty()){
            Pair pp = q.remove();
            int level = pp.level;
            String current = pp.currWord;

            if(current ==endWord){
                return level;
            }
            for(int i=0; i<current.length(); i++){

                char [] charArray = current.toCharArray();
                for(char ch ='a'; ch<= 'z'; ch++){
                    charArray[i]=ch;

                    String temp =new String(charArray);

                    if(hs.contains(temp)){
                        hs.remove(temp);
                        Pair p1 = new Pair(temp, level+1);
                        q.add(p1);
                    }
                }
            }

        }return 0;
    }



    public static void main(String[] args) {

    }
}
