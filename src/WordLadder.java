import java.util.*;


//get a pair class to keep the track of the level and the word
class Pair{
    int level;
    String currWord;
    Pair(String currWord, int level){
        this.currWord =currWord;
        this.level = level;
    }
}



public class WordLadder {

  //method to reach the endWord from beginWord
    public static int wordLadder(String beginWord, String endWord, List<String> wordList){
        //first put the list in hashset to eliminate the duplicates, and remove the word to start search with
        HashSet<String> hs = new HashSet<>(wordList);
        hs.remove(beginWord);

        //queue will contain the info of level and the word
        Queue<Pair> q = new LinkedList<>();
        Pair pair = new Pair(beginWord, 1);
        q.add(pair);


        while(!q.isEmpty()){
            Pair pp = q.remove();
            int level = pp.level;
            String current = pp.currWord;

            //if match found then return its level
            if(current ==endWord){
                return level;
            }
            //else run a loop to the length of the current, for eg: KUNAL will run 0-4
            for(int i=0; i<current.length(); i++){

                //get a char array to store the characters in String, and then update the characters one by one
                //and repeat it with the consecutive elements of the array from a-z
                //then collect the char array and store it in string, and if my list contains that string,
                //then remove it from the list and in the meantime add it into the queue with addition level and repeat the process
                //
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
            // if could not find the endWord then return 0
        }return 0;
    }



    public static void main(String[] args) {

    }
}
