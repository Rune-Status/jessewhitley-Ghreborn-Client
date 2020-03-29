package com.Ghreborn.client.particles;

import java.util.HashMap;
import java.util.Map;

public class ParticleAttachment {
    private static final Map<Integer, int[][]> attachments = new HashMap<>();
    public static int[][] getAttachments(int model) {
        return attachments.get(model);
    }
    static {
        /* TokHaar Kal */
        attachments.put(62575, new int[][] {{ 0, 1 }, { 1, 1 }, { 3, 1 }, { 131, 1 }, { 132, 1 }, { 133, 1 }, { 134, 1 }, { 135, 1 }, { 136, 1 }, { 137, 1 }, { 138, 1 }, { 139, 1 }, { 140, 1 }, { 141, 1 }, { 142, 1 }, { 145, 1 },});
        /* Completionist Cape */
        attachments.put(65295, new int[][] {{494, 3}, {488 , 3}, {485 , 3}, {476 , 3}, {482 , 3}, {479 , 3}, {491 , 3},});
        attachments.put(65328, new int[][] {{494, 3}, {488 , 3}, {485 , 3}, {476 , 3}, {482 , 3}, {479 , 3}, {491 , 3},});
        /*rd cape */
        attachments.put(40122, new int[][] {{235, 0}, {229 , 0}, {241 , 0}, {238 , 0}, {232 , 0},});
        /*master dungeoneering cape*/
        attachments.put(59885, new int[][] {{387, 2}, {385 , 2}, {376 , 2}, {382 , 2}, {379 , 2},});
        
        attachments.put(63604, new int[][] {{799, 4}, {800 , 4}, {802 , 4}, {804 , 4}, {804 , 4}, {807 , 4}, {752 , 4}, {792 , 4}, {791 , 4}, {790 , 4}, {789 , 4}, {787 , 4},{786 , 4},{785 , 4},{784 , 4},{793 , 4},{794 , 4},{796 , 4}, 
                                            {750, 4}, {751 , 4}, {507 , 4}, {753 , 4}, {805 , 4}, {803 , 4}, {801 , 4}, {797 , 4}, {795 , 4}, {783 , 4}, {744 , 4}, {745 , 4}, {746 , 4}, {788 , 4},{749 , 4},{793 , 4},{794 , 4},{796 , 4},
                                            {747, 4}, {748 , 4}, {488 , 4}, {504 , 4}, {505 , 4}, {506 , 4}, {491 , 4}, {508 , 4}, {754 , 4}, {1117 , 4}, {755 , 4}, {1118 , 4}, {1093 , 4}, {1094 , 4},{1095 , 4},{901 , 4},{902 , 4},{473 , 4},
                                            {474, 4}, {743 , 4}, {475 , 4}, {744 , 4}, {476 , 4},});
        attachments.put(29616, new int[][] {{318, 0}});
        
    }
}