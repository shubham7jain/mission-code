/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
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
listnode* detectCycle(listnode* A) {
    if(A == NULL || A->next == NULL)
        return NULL;
    listnode* slow = A->next;
    listnode* fast = A->next->next;
    while(slow!=NULL && fast!=NULL) {
        if(slow == fast) {
            break;
        } else {
            slow = slow->next;
            if(fast->next!=NULL)
                fast = fast->next->next;
            else
                fast = NULL;
        }
    }
    if(slow==NULL || fast == NULL)
        return NULL;
    while(A!=slow) {
        A = A->next;
        slow = slow->next;
    }
    return A;
}
