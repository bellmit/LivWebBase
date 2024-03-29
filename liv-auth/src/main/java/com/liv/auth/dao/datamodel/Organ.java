package com.liv.auth.dao.datamodel;

import com.baomidou.mybatisplus.annotation.*;
import com.liv.api.base.base.BaseBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 组织机构表
 * </p>
 *
 * @author Liv
 * @since 2020-05-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("auth.organ")
@ApiModel(value="Organ对象", description="组织机构表")
@EqualsAndHashCode(callSuper = false)
public class Organ extends BaseBean<Organ> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ORGAN_ID", type = IdType.AUTO)
    private Long organId;

    @ApiModelProperty(value = "机构名称")
    @TableField("ORGAN_NAME")
    @NotEmpty(message = "机构名称不能为空")
    private String organName;

    @ApiModelProperty(value = "上级机构ID")
    @TableField("PARENT_ID")
    private Long parentId;

    @ApiModelProperty(value = "机构级别")
    @TableField("ORGAN_LEVEL")
    @NotEmpty(message = "机构级别不能为空")
    private String organLevel;

    @ApiModelProperty(value = "机构类型")
    @TableField("ORGAN_TYPE")
    @NotEmpty(message = "机构类型不能为空")
    private String organType;

    @ApiModelProperty(value = "机构描述")
    @TableField("DESCRIPTION")
    private String description;

    @ApiModelProperty(value = "是否删除1 是 0否")
    @TableField("DEL")
    @TableLogic(delval = "1",value = "0")
    private String del = "0";

    @TableField(exist = false)
    private List<Organ> children;
}
