# TIL_Day_86

> 2022년 11월 19일

## 동적 계획법(DP, Dynamic Programming)

> 동적 계획법이란 복잡한 문제를 간단한 여러 개의 문제로 나누어 푸는 방법을 말한다. 이것은 부분 문제 반복과 최적 부분 구조를 가지고 있는 알고리즘을 일반적인 방법에 비해 더욱 적은 시간 내에 풀 때 사용한다.

### 동적 계획법의 사용 조건

1. Overlapping Subproblems(중복 부분 문제)
   - DP는 기본적으로 문제를 나누고 그 문제의 결과 값을 재활용해서 전체 답을 구한다. 그래서 **동일한 작은 문제들이 반복하여 나타나는 경우에 사용이 가능**하다.
   - 즉, DP는 부분 문제의 결과를 저장하여 재 계산하지 않을 수 있어야 하는데, 해당 **부분 문제가 반복적으로 나타나지 않는다면 재사용이 불가능하니 부분 문제가 중복되지 않는 경우에는 사용할 수 없다.**
2. Optimal Substructure(최적 부분 구조)
   - **부분 문제의 최적 결과 값을 사용해 전체 문제의 최적 결과를 낼 수 있는 경우**를 의미한다. 그래서 특정 문제의 정답은 문제의 크기에 상관없이 항상 동일하다.

### 동적 계획법의 과정

DP는 **특정한 경우에 사용하는 알고리즘이 아니라 하나의 방법론이므로 다양한 문제해결에 쓰일 수 있다.**

일반적으로 DP를 사용하는 과정은 다음과 같다.

1. DP로 풀 수 있는 문제인지 확인한다.
   - **조건들이 충족되는 문제인지 체크**
2. 문제의 변수 파악
   - DP는 현재 변수에 따라 그 결과 값을 찾고 그것을 전달하여 재사용하는 거친다. 즉, 문제 내 변수의 개수를 알아내야 한다는 것. 이것을 영어로 "state"를 결정한다고 한다.
3. 변수 간 관계식 만들기(점화식)
   - 변수들에 의해 결과 값이 달라지지만 동일한 변수 값인 경우 결과는 동일하다. 또한 그 결과 값을 그대로 이용해야하므로 그 관계식을 만들어낼 수 있어야 한다.
   - 이러한 식을 **점화식**이라고 부르며 이것을 통해 짧은 코드 내에서 반복/재귀를 통해 문제가 자동으로 해결되도록 구축할 수 있게 된다.
4. 메모하기(memoization on tabulation)
   - 변수 간 관계식까지 정상적으로 생성되었다면 **변수의 값에 따른 결과를 저장**해야 한다. 이것을 메모한다고 하여 **Memoization**이라고 부른다.
5. 기저 상태 파악하기
   - **가장 작은 문제의 상태**를 알아야 한다.
6. 구현하기
   - DP는 2가지 방식으로 구현할 수 있다.
     1. Bottom-Up (Tabulation 방식) - 반복문 사용
     2. Top-Down (Memoization 방식) - 재귀 사용

### JAVA로 구현

1. Bottom-Up 방식
   - 아래에서부터 계산을 수행하고 누적시켜서 전체 큰 문제를 해결하는 방식
2. Top-Down 방식
   - 위에서부터 바로 호출을 시작하여 내려간 다음 해당 결과 값을 재귀를 통해 전이시켜 재활용하는 방식

```java
public class Fibonacci{
    // DP 를 사용 시 작은 문제의 결과값을 저장하는 배열
    // Top-down, Bottom-up 별개로 생성하였음(큰 의미는 없음)
    static int[] topDown_memo; 
    static int[] bottomup_table;
    public static void main(String[] args){
        int n = 30;
        topDown_memo = new int[n+1];
        bottomup_table = new int[n+1];
        
        long startTime = System.currentTimeMillis();
        System.out.println(naiveRecursion(n));
        long endTime = System.currentTimeMillis();
        System.out.println("일반 재귀 소요 시간 : " + (endTime - startTime));
        
        System.out.println();
        
        startTime = System.currentTimeMillis();
        System.out.println(topDown(n));
        endTime = System.currentTimeMillis();
        System.out.println("Top-Down DP 소요 시간 : " + (endTime - startTime));
        
        System.out.println();
        
        startTime = System.currentTimeMillis();
        System.out.println(bottomUp(n));
        endTime = System.currentTimeMillis();
        System.out.println("Bottom-Up DP 소요 시간 : " + (endTime - startTime));
    }
    
    // 단순 재귀를 통해 Fibonacci를 구하는 경우
    // 동일한 계산을 반복하여 비효율적으로 처리가 수행됨
    public static int naiveRecursion(int n){
        if(n <= 1)
            return n;
        
        return naiveRecursion(n-1) + naiveRecursion(n-2);
    }
    
    // DP Top-Down을 사용해 Fibonacci를 구하는 경우
    public static int topDown(int n){
        // 기저 상태 도달 시, 0, 1로 초기화
        if(n < 2)
            return topDown_memo[n] = n;
        
        // 메모에 계산된 값이 있으면 바로 반환
        if(topDown_memo[n] > 0)
            return topDown_memo[n];
        
        // 재귀를 사용하고 있음
        topDown_memo[n] = topDown(n-1) + topDown(n-2);
        
        return topDown_memo[n];
    }
    
    // DP Bottom-Up을 사용해 Fibonacci를 구하는 경우
    public static int bottomUp(int n){
        // 기저 상태의 경우 사전에 미리 저장
        bottomup_table[0] = 0; bottomup_table[1] = 1;
        
        // 반복문을 사용하고 있음
        for(int i=2; i<=n; i++){
            // Table을 채워나감
            bottomup_table[i] = bottomup_table[i-1] + bottomup_table[i-2];
        }
        return bottomup_table[n];
    }
}

/*
결과
832040
일반 재귀 소요 시간 : 9

832040
Top-Down DP 소요 시간 : 0

832040
Bottom-Up DP 소요 시간 : 0
*/