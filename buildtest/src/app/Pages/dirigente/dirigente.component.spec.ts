import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DirigenteComponent } from './dirigente.component';

describe('DirigenteComponent', () => {
  let component: DirigenteComponent;
  let fixture: ComponentFixture<DirigenteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DirigenteComponent]
    });
    fixture = TestBed.createComponent(DirigenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
