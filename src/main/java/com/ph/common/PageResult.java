package com.ph.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("分页数据")
public class PageResult implements Serializable {

    private static final long serialVersionUID = 8636297452986775353L;

    @ApiModelProperty(notes = "当前页码")
    private long pageNum;

    @ApiModelProperty(notes = "每页数量")
    private long pageSize;

    @ApiModelProperty(notes = "记录总数")
    private long totalSize;

    @ApiModelProperty(notes = "页码总数")
    private long totalPages;

    /**
     * 根据 Mybatis plus 的分页结果封装返回给前端的分页信息
     *
     * @param page Mybatis plus 的分页结果
     * @return {@link PageResult}
     */
    public static PageResult create(IPage page) {
        return new PageResult(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages());
    }
}
