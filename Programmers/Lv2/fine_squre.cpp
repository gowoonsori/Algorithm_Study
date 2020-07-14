using namespace std;

int get_gcd(int a, int b){
    int c = 0;
    while( b > 0){
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

long long solution(int w,int h) {
    long long answer =  (long long)w * (long long)h;
    int gcd = (w > h) ? get_gcd(w,h) : get_gcd(h,w);
    
    answer -= gcd * ( (w/gcd)+(h/gcd) - 1 ) ;
    
    return answer;
}