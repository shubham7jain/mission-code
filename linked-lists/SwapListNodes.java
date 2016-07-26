/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
 * 
 * @Output head pointer of list.
 */
listnode* swapPairs(listnode* A) {
    if(A == NULL || A->next == NULL) {
        return A;
    }
    listnode* head = A->next;
    listnode* temp = A->next->next;
    A->next->next = A;
    A->next = temp;
    listnode* prev = head->next;
    listnode* current  = temp;
    while(current!=NULL && current->next!=NULL) {
        listnode* next = current->next;
        temp = next->next;
        next->next = current;
        prev->next = next;
        current->next = temp;
        prev = current;
        current = current->next;
    }
    return head;
}
