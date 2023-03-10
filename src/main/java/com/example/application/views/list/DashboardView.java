/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.application.views.list;

import com.example.application.data.service.CrmService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;

/**
 *
 * @author PC
 */
@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Dashboard | Vaadin Crm")
@PermitAll
public class DashboardView extends VerticalLayout{

    private CrmService service;

    public DashboardView(CrmService service) {
        this.service = service;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        add(getCompaniesChart(), getCompaniesChart());
        
    }

    private Component getContactStats() {
        Span stats = new Span(service.countContact() + "contact");
        stats.addClassNames("text-xl", "mt-m");
        return stats;
    }

    private Component getCompaniesChart() {
        Chart chart = new Chart(ChartType.PIE);
        
        DataSeries dataseries = new DataSeries();
        service.findAllCompanies().forEach(company ->{
            dataseries.add(new DataSeriesItem(company.getName(), company.getEmployeeCount()));
        });
        chart.getConfiguration().setSeries(dataseries);
        return chart;
    }
    
}
