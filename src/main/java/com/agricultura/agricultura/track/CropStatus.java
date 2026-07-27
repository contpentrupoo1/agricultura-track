package com.agricultura.agricultura.track;

public enum CropStatus {
    PLANNED,      // The crop is budgeted and scheduled, but not yet in the ground.
    PLANTING,     // Actively putting seeds/seedlings into the plot.
    GROWING,      // The longest phase; tracking irrigation, fertilizer, and cultivation.
    HARVESTING,   // The crop is actively being pulled from the field.
    COMPLETED,    // Harvest is finished, and the final yield is recorded.
    FAILED
}
