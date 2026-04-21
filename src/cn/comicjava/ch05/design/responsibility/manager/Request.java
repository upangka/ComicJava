package cn.comicjava.ch05.design.responsibility.manager;

/**
 * @param type    申请类别
 * @param content 申请内容
 * @param number  数量
 */
public record Request(
        String type,
        String content,
        Integer number) {
}
