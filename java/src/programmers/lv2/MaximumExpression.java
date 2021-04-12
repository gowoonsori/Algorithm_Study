package programmers.lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


//swap을 이용한 백트래킹 순열
public class MaximumExpression {
    long answer = -1;
    char[] op;
    List<Long> numbers = new ArrayList<>();
    List<Character> operations = new ArrayList<>();

    public long solution(String expression) {
        op = checkOperation(expression); //사용된 연산자 체크

        //숫자와 연산자 분리
        StringBuilder sb = new StringBuilder();
        for(char ch : expression.toCharArray()){
            if(ch >= '0' ) sb.append(ch);
            else{
                numbers.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operations.add(ch);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));  //마지막 숫자는 뒤에 연산자가 없으므로 삽입

        //연산자 운선순위에 따른 순열 실행
        permutation(0);
        return answer;
    }

    private char[] checkOperation(String expressionCpy){
        StringBuilder sb = new StringBuilder();
        if(expressionCpy.contains("+")) sb.append('+');
        if(expressionCpy.contains("*")) sb.append('*');
        if(expressionCpy.contains("-")) sb.append('-');
        return sb.toString().toCharArray();
    }

    private void permutation(int depth){
        if(depth == op.length){
            long result = calculateExpression();
            answer = Math.max(result,answer);
        }
        for(int i=depth; i < op.length; i++){
            swap(i,depth);
            permutation(depth+1);
            swap(i,depth);
        }
    }

    private long calculateExpression(){
        List<Long> numbersCpy = new ArrayList<>(numbers);
        List<Character> operationsCpy = new ArrayList<>(operations);

        for(int i = 0; i < op.length; i++){
            for(int j=0; j < operationsCpy.size(); j++){
                if(operationsCpy.get(j) == op[i]){
                    Long result = calculateNumber(numbersCpy.remove(j),numbersCpy.remove(j),op[i]);
                    numbersCpy.add(j,result);
                    operationsCpy.remove(j);
                    j--; //remove시에 index가 한개씩 앞으로 밀리기 때문에
                }
            }
        }
        return Math.abs(numbersCpy.get(0));
    }

    private Long calculateNumber(Long a, Long b, char oper){
        switch (oper){
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '-':
                return a - b;
        }
        return -1L;
    }

    private void swap(int i, int j){
        char tmp = op[i];
        op[i] = op[j];
        op[j] = tmp;
    }

    @Test
    void test(){
        Assertions.assertEquals(60420, solution("100-200*300-500+20"	));
    }
}
