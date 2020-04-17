package com.lacker.micros.data.repository;

import com.lacker.micros.data.domain.schema.DataTable;
import com.lacker.micros.data.domain.schema.TableRepository;
import com.lacker.micros.data.repository.mapper.ColumnMapper;
import com.lacker.micros.data.repository.mapper.TableMapper;
import com.lacker.micros.domain.exception.NotFoundAppException;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TableRepositoryImpl implements TableRepository {

    private final TableMapper tableMapper;
    private final ColumnMapper columnMapper;

    TableRepositoryImpl(
            TableMapper tableMapper,
            ColumnMapper columnMapper) {
        this.tableMapper = tableMapper;
        this.columnMapper = columnMapper;
    }

    @Override
    public List<DataTable> findAll() {
        return tableMapper.findAll();
    }

    @Override
    public DataTable find(@NotNull Long id) {
        DataTable table = tableMapper.find(id);

        if (table == null) {
            throw new NotFoundAppException();
        }

        table.setColumns(columnMapper.findByTable(id));

        return table;
    }

    @Override
    public void save(@NotNull DataTable table) {

    }
}
