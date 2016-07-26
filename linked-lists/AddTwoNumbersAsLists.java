/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807
*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 * 
 * typedef struct ListNode listnode;
 * 
 * listnode* listnode_new(int val) {
 *     listnode* node = (listnode *) malloc(sizeof(listnode));
 *     node->val = val;
 *     node->next = NULL;
 *     return node;
 * }
 */
/**
 * @input A : Head pointer of linked list 
 * @input B : Head pointer of linked list 
 * 
 * @Output head pointer of list.
 */


listnode* addTwoNumbers(listnode* A, listnode* B) {
    listnode* res = NULL, *prev= NULL, *temp=NULL;
    int c = 0, sum  = 0;
    while(A!=NULL || B!=NULL) {
        sum = 0;
        if(A!=NULL) {
            sum  = sum + A->val;
            A = A->next;
        }
        if(B!=NULL) {
            sum = sum +B->val;
            B = B->next;
        }
        sum = sum + c;
        c = sum/10;
        temp = listnode_new(sum%10);
        if(res == NULL) {
            res = temp;
        } else {
            prev->next = temp;
        }
        prev = temp;
    }
    if(c!=0) {
        temp = listnode_new(c);
        prev->next = temp;
    }
    return res;
}
