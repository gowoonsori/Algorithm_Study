#include <iostream>
using namespace std;

struct list{
	int num;
	list* next;
};

int main() {
	list *list_h;
	list list1; list1.num = 1;
	list list2; list2.num = 2;
	list list3; list3.num = 3;
	list list4; list4.num = 4;
	list list5; list5.num = 5;
	list_h = &list1;
	list1.next = &list2;
	list2.next = &list3;
	list3.next = &list4;
	list4.next = &list5;
	list5.next = NULL;
	
	list2.next = &list4;
	
	while(list_h != NULL){
		cout<< list_h->num << " ";
		list_h = list_h->next;
	}
	cout <<"NULL";
	return 0;
}