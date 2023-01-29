package com.besscroft.xanadu.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import com.besscroft.xanadu.common.param.file.GetFileInfoParam;
import com.besscroft.xanadu.common.param.file.GetItemByKeyParam;
import com.besscroft.xanadu.common.result.CommonResult;
import com.besscroft.xanadu.common.vo.FileInfoVo;
import com.besscroft.xanadu.common.vo.StorageInfoVo;
import com.besscroft.xanadu.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 文件接口
 * @Author Bess Croft
 * @Date 2023/1/20 21:54
 */
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @SaIgnore
    @Operation(summary = "默认驱动信息")
    @GetMapping("/defaultStorage")
    public CommonResult<StorageInfoVo> defaultStorage() {
        return CommonResult.success(fileService.defaultStorage());
    }

    @SaIgnore
    @Operation(summary = "默认文件列表")
    @GetMapping("/defaultItem")
    public CommonResult<List<FileInfoVo>> defaultItem() {
        return CommonResult.success(fileService.defaultItem());
    }

    @SaIgnore
    @Operation(summary = "首页文件列表")
    @GetMapping("/getItem")
    public CommonResult<List<FileInfoVo>> base(@RequestParam(value = "storageId") Long storageId,
                                               @RequestParam(value = "folderPath") String folderPath) {
        return CommonResult.success(fileService.getItem(storageId, folderPath));
    }

    @SaIgnore
    @Operation(summary = "首页文件列表")
    @PostMapping("/getItemByKey")
    public CommonResult<List<FileInfoVo>> baseByKey(@RequestBody @Valid GetItemByKeyParam param) {
        return CommonResult.success(fileService.getItemByKey(param.getStorageKey(), param.getFolderPath()));
    }

    @SaIgnore
    @Operation(summary = "文件信息")
    @PostMapping("/getFileInfo")
    public CommonResult<FileInfoVo> getFileInfo(@RequestBody GetFileInfoParam param) {
        return CommonResult.success(fileService.getFileInfo(param.getStorageKey(), param.getFilePath(), param.getFileName()));
    }

}