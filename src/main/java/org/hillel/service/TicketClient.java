package org.hillel.service;

import org.hillel.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class TicketClient {

    @Autowired
    private TransactionalJourneyService transactionalJourneyService;

    @Autowired
    private TransactionalVehicleService vehicleService;

    @Autowired
    private TransactionalFreePlaces freePlaces;

    @Autowired
    private TransactionalStopService stopService;

    @Autowired
    private TransactionalStopAddService stopAddService;

    public JourneyEntity createOrUpdate(final JourneyEntity journeyEntity) {
        return transactionalJourneyService.createOrUpdate(journeyEntity);
    }

    public Collection<JourneyEntity> findAllJourneys(){
        return transactionalJourneyService.findAll();
    }

    public Collection<JourneyEntity> findAllAsNativeJourneys(){
        return transactionalJourneyService.findAllAsNative();
    }

    public Collection<JourneyEntity> findAllAsCriteriaJourneys(){
        return transactionalJourneyService.findAllAsCriteria();
    }

    public Collection<JourneyEntity> findAllAsNamedQueryJourneys(String name){
        return transactionalJourneyService.findAllAsNamedQuery(name);
    }

    public Collection<JourneyEntity> findAllJourneysAsStoredProcedure() {
        return transactionalJourneyService.findAllAsStoredProcedure();
    }

    public Collection<JourneyEntity> findAllAsProcedure() {
        return transactionalJourneyService.findAllAsStoredProcedure();
    }

    public VehicleEntity createOrUpdate(final VehicleEntity vehicleEntity) {
        return vehicleService.createOrUpdate(vehicleEntity);
    }

    public Collection<VehicleEntity> findAllVehicles(){
        return vehicleService.findAll();
    }

    public Collection<VehicleEntity> findAllAsNativeVehicles(){
        return vehicleService.findAllAsNative();
    }

    public Collection<VehicleEntity> findAllAsCriteriaVehicles(){
        return vehicleService.findAllAsCriteria();
    }

    public Collection<VehicleEntity> findAllAsNamedQueryVehicles(String name){
        return vehicleService.findAllAsNamedQuery(name);
    }

    public Collection<VehicleEntity> findAllVehiclesAsStoredProcedure() {
        return vehicleService.findAllAsStoredProcedure();
    }

    public void removeVehicle(VehicleEntity entity) {
        vehicleService.remove(entity);
    }

    public FreePlacesEntity createOrUpdate(FreePlacesEntity freePlacesEntity) {
        return freePlaces.createOrUpdate(freePlacesEntity);
    }

    public Collection<FreePlacesEntity> findAllPlaces(){
        return freePlaces.findAll();
    }

    public Collection<FreePlacesEntity> findAllAsNativePlaces(){
        return freePlaces.findAllAsNative();
    }

    public Collection<FreePlacesEntity> findAllAsCriteriaPlaces(){
        return freePlaces.findAllAsCriteria();
    }

    public Collection<FreePlacesEntity> findAllAsNamedQueryPlaces(String name){
        return freePlaces.findAllAsNamedQuery(name);
    }

    public Collection<FreePlacesEntity> findAllPlacesAsStoredProcedure() {
        return freePlaces.findAllAsStoredProcedure();
    }

    public StopEntity createOrUpdate(StopEntity stopEntity) {
        return stopService.createOrUpdate(stopEntity);
    }

    public void removeStop(StopEntity stopEntity) {
        stopService.remove(stopEntity);
    }

    public Collection<StopEntity> findAllStops(){
        return stopService.findAll();
    }

    public Collection<StopEntity> findAllAsNativeStops(){
        return stopService.findAllAsNative();
    }

    public Collection<StopEntity> findAllAsCriteriaStops(){
        return stopService.findAllAsCriteria();
    }

    public Collection<StopEntity> findAllAsNamedQueryStops(String name){
        return stopService.findAllAsNamedQuery(name);
    }

    public Collection<StopEntity> findAllStopsAsStoredProcedure() {
        return stopService.findAllAsStoredProcedure();
    }

    public Collection<StopAddInfoEntity> findAllStopsInfo(){
        return stopAddService.findAll();
    }

    public Collection<StopAddInfoEntity> findAllAsNativeStopsInfo(){
        return stopAddService.findAllAsNative();
    }

    public Collection<StopAddInfoEntity> findAllAsCriteriaStopsInfo(){
        return stopAddService.findAllAsCriteria();
    }

    public Collection<StopAddInfoEntity> findAllAsNamedQueryStopsInfo(String name){
        return stopAddService.findAllAsNamedQuery(name);
    }

    public Collection<StopAddInfoEntity> findAllStopsInfoAsStoredProcedure() {
        return stopAddService.findAllAsStoredProcedure();
    }
}
