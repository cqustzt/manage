package edu.whitehou.entity;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;
/**
 * @author : white.hou
 * @description : pageHelper实体类1
 * @date: 2018/11/20_15:49
 */
public class PageBean<T> {
        // 当前页
        private Integer pageNum = 1;
        // 每页显示的总条数
        private Integer pageSize = 10;
        // 总条数
        private Integer totalNum;
        // 是否有下一页
        private Integer isMore;
        // 总页数
        private Integer totalPage;
        // 开始索引
        private Integer startIndex;
        // 分页结果
        private Collection<T> items;

        public PageBean() {
            super();
        }

        public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
            super();
            this.pageNum = currentPage;
            this.pageSize = pageSize;
            this.totalNum = totalNum;
            this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
            this.startIndex = (this.pageNum-1)*this.pageSize;
            this.isMore = this.pageNum >= this.totalPage?0:1;
        }

        public Integer getCurrentPage() {
            return pageNum;
        }

        public void setCurrentPage(Integer currentPage) {
            this.pageNum = currentPage;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(Integer totalNum) {
            this.totalNum = totalNum;
        }

        public Integer getIsMore() {
            return isMore;
        }

        public void setIsMore(Integer isMore) {
            this.isMore = isMore;
        }

        public Integer getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(Integer totalPage) {
            this.totalPage = totalPage;
        }

        public Integer getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(Integer startIndex) {
            this.startIndex = startIndex;
        }

        public Collection<T> getItems() {
            return items;
        }

        public void setItems(Collection<T> items) {
            this.items = items;
        }
    }

