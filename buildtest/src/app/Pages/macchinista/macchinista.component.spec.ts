import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MacchinistaComponent } from './macchinista.component';

describe('MacchinistaComponent', () => {
  let component: MacchinistaComponent;
  let fixture: ComponentFixture<MacchinistaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MacchinistaComponent]
    });
    fixture = TestBed.createComponent(MacchinistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
