package com.mk.common;

import com.mk.model.domain.TagScores;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 二进制操作工具类
 */
public class BinaryUtils {


    public static void main(String[] args) {
/*        List<String> tagsList = getTagsList();
        System.out.println("期望结果：110");
        Integer tagListBinary = tagListToBinary(tagsList);
        System.out.println("实际结果：" + Integer.toBinaryString(tagListBinary));*/

        Integer scores = scoresByTagsList(getTagsList(), getTagsList2());
        System.out.println(scores);


    }

    /**
     * 计算两个标签列表的相似度分数
     * 1. 将标签字符列表转换为二进制为
     * 2. 计算两个二进制相似度分数
     *
     */

    /**
     *
     * @param tags_1
     * @param tags_2
     * @return
     */
    // 计算两个计算两个标签相似度分数
    public static Integer scoresByTagsList(List<String> tags_1, List<String> tags_2){
        List<String> intersectTags = tags_1.stream().filter(tag -> tags_2.contains(tag)).collect(Collectors.toList());
        System.out.println(intersectTags);
        return intersectTags.size();
    }

    // 计算两个二进制权值相似度分数
    public static Integer scoresByBinaryValue(Integer value_1, Integer value_2){
        return Integer.bitCount(value_1 & value_2);
    }

    // 将标签列表转换为二进制权值
    public static Integer tagListToBinary(List<String> tagList){
        Integer tagScoresListValue = 0;
        // 获取数据库中所有的标签权值
        List<TagScores> tagScores = getTagScores();
        List<Integer> tagScoresList = tagList.stream().map(tag -> {
            // 查询标签对应的二进制位的权值
            return tagScores.stream().filter(scores -> scores.getTagName().equals(tag)) // 根据标签名匹配过滤（tagScores唯一）
                    .findFirst()
                    .get()
                    .getIndexValue(); // 获取权值
        }).collect(Collectors.toList());

        // 将权值拼接为二进制
        for (Integer value : tagScoresList) {
            tagScoresListValue += value;
        }
        return tagScoresListValue;
    }

    // 伪造数据库中标签权值
    private static List<TagScores> getTagScores(){
        TagScores tagScores1 = new TagScores();
        tagScores1.setId(1);
        tagScores1.setTagName("Java");
        tagScores1.setIndexValue(1);
        TagScores tagScores2 = new TagScores();
        tagScores2.setId(2);
        tagScores2.setTagName("大一");
        tagScores2.setIndexValue(2);
        TagScores tagScores3 = new TagScores();
        tagScores3.setId(3);
        tagScores3.setTagName("男");
        tagScores3.setIndexValue(4);
        return List.of(tagScores1, tagScores2, tagScores3);
    }

    // 伪造标签列表数据
    private static List<String> getTagsList(){
        return List.of("大一", "男","123","Python");
    }
    private static List<String> getTagsList2(){
        return List.of( "男", "Java","大一", "电影");
    }

    // 通过二进制中1的个数，计算分数
    private static int getScores(int value){
        String binaryString = Integer.toBinaryString(value);
//        "110"
        int scores = binaryString.lastIndexOf(1) + 1;
        return 0;
    }
}
