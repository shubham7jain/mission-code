/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
 * @input B : Integer
 * 
 * @Output head pointer of list.
 */
listnode* partition(listnode* A, int B) {
    listnode* last = NULL;
    if(A == NULL || A->next==NULL)
        return A;
    listnode* temp = A;
    while(A->next!=NULL) {
        A = A->next;
    }
    last = A;
    listnode* head = temp;
    listnode* start = temp;
    while(start!=A && start->val>=B) {
        last->next = start;
        last = last->next;
        head = start->next;
        start = start->next;
        last->next = NULL;
    }
    if(start == A && start->val>=B) {
        last->next = start;
        last = last->next;
        head = start->next;
        start = start->next;
        last->next = NULL;
        return head;
    }
    listnode* prev = start;
    while(start!=A) {
        if(start->val >= B) {
            last->next = start;
            last = last->next;
            start = start->next;
            prev->next = start;
            last->next = NULL;
        } else {
            prev = start;
            start = start->next;
        }
    }
    if(start->val>=B) {
        last->next = start;
        prev->next = start->next;
        start->next = NULL;
    }
    return head;
}
